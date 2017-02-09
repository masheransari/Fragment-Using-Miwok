package com.example.asheransari.miwokpractices;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by asher.ansari on 9/26/2016.
 */
public class WordAdapter extends ArrayAdapter<variableClass> {

    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<variableClass> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,  0, words );
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent)
    {
        View listItemView = converView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        variableClass CurrentWOrd = getItem(position);

        TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwok_text);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miworkTextView.setText(CurrentWOrd.getmMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView DefaultTextView = (TextView) listItemView.findViewById(R.id.default_text);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        DefaultTextView.setText(CurrentWOrd.getmDefaultranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (CurrentWOrd.hasImage())
        {
            imageView.setImageResource(CurrentWOrd.getmImageResourseID());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
            int color = ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
