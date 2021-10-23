package com.example.prozrenie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button documentButton;
        public Document document;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            documentButton = (Button) itemView.findViewById(R.id.document_button);
            documentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, document_read.class);
                    int source = document.getSource();
                    intent.putExtra("source", source);
                    context.startActivity(intent);
                }
            }
            );

        }
    }

    @Override
    public DocumentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_document, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(DocumentAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Document document = mContacts.get(position);

        holder.document = document;

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(document.getName());
        Button button = holder.documentButton;
        button.setText("Открыть");
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
    private List<Document> mContacts;

    // Pass in the contact array into the constructor
    public DocumentAdapter(List<Document> contacts) {
        mContacts = contacts;
    }
}

