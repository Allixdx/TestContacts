package com.example.test.adapters;

import static com.example.test.MainActivity.callPermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import android.Manifest;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.infoActivity;
import com.example.test.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> ContactList;

    public ContactAdapter(List<Contact> ContactList) {
        this.ContactList = ContactList;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly= LayoutInflater.from(parent.getContext());
        View view = ly.inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactHolder holder, int position) {
        Contact c = ContactList.get(position);
        holder.setdata(c);

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context, infoActivity.class);
                i.putExtra("contact", c);
                context.startActivity(i);
            }
        });

        holder.tvTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:" + c.getTel()));
                    view.getContext().startActivity(i);
                } else {
                    ActivityCompat.requestPermissions((Activity) view.getContext(), new String[]{Manifest.permission.CALL_PHONE}, callPermission);
                }
            }
        });

        holder.tvlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = c.getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() { return ContactList.size(); }

    public class ContactHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTel;
        TextView tvlink;
        Contact contact;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvTel = itemView.findViewById(R.id.tel);
            tvlink = itemView.findViewById(R.id.link);
        }

        public void setdata(Contact c) {
            contact = c;
            tvName.setText(c.getName());
            tvTel.setText(c.getTel());
            tvlink.setText(c.getLink());
        }
    }
}
