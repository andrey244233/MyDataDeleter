package com.example.home_pc.mydatadeleter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> listContacts;
    TextView textViewName;
    TextView textViewPhoneNumber;

    public RecViewAdapter(Context context, ArrayList<Contact> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact currentContact = listContacts.get(position);
        String name = currentContact.getName();
        String number = currentContact.getPhoneNumber();

        textViewName.setText(name);
        textViewPhoneNumber.setText(number);
    }

    @Override
    public int getItemCount() {
        if (listContacts == null) {
            return 0;
        }
        return listContacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        public ContactViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewPhoneNumber = itemView.findViewById(R.id.tvPhone);
        }
    }
}
