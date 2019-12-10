package com.example.android.cheeselist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<CheeseItem> cheeseItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sample_main);

        // We want to allow modifications to the list so copy the dummy data array into an ArrayList
        cheeseItemList = new ArrayList<CheeseItem>();
        for (int i = 0, z = Cheeses.CHEESES.length ; i < z ; i++) {
            cheeseItemList.add(new CheeseItem(Cheeses.CHEESES[i]));
        }

        listView = (ListView) this.findViewById(android.R.id.list);
        listView.setAdapter(new MyAdapter(this, cheeseItemList));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(mActionModeCallback);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = startActionMode(mActionModeCallback);
                listView.setItemChecked(position, true);
                view.setSelected(true);
                return true;
            }
        });

        //Appbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.inflateMenu(R.menu.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Respond to clicks on the actions in the appbar
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        // TODO
                        Toast.makeText(getApplicationContext(), "Settings not implemented", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    private ActionMode mActionMode;

    private AbsListView.MultiChoiceModeListener mActionModeCallback = new AbsListView.MultiChoiceModeListener() {

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position,
                                              long id, boolean checked) {
            // Here you can do something when items are selected/de-selected,
            // such as update the title in the CAB
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // Respond to clicks on the actions in the CAB
            switch (item.getItemId()) {
                case R.id.menu_edit:
                    // TODO
                    // Show a toast
                    Toast.makeText(getApplicationContext(), "Edit not implemented", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.menu_remove:
                    SparseBooleanArray checkedItemsIds = listView.getCheckedItemPositions();
                    int nItems = listView.getAdapter().getCount();
                    int d = 0; int j = 0;
                    for (int i = 0; i < nItems; i++) {
                        if (checkedItemsIds.get(i)){
                            j=i-d;
                            ((MyAdapter) listView.getAdapter()).remove(listView.getAdapter().getItem(j));
                            ((MyAdapter) listView.getAdapter()).notifyDataSetChanged();
                            d++;
                        }
                    }
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.menu_settings:
                    // TODO
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.cab, menu);
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // Here you can make any necessary updates to the activity when
            // the CAB is removed. By default, selected items are deselected/unchecked.
            mActionMode = null;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // Here you can perform updates to the CAB due to
            // an invalidate() request
            return false;
        }
    };


    /**
     * A simple array adapter that creates a list of cheeses.
     */
    class MyAdapter<C> extends ArrayAdapter<CheeseItem> {

        public MyAdapter(@NonNull Context context, @NonNull List<CheeseItem> items) {
            super(context, R.layout.list_item, items);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
            }

            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(getItem(position).getName());
            ImageView imageView = ((ImageView) convertView.findViewById(R.id.star_icon));

            final CheeseItem item = cheeseItemList.get(position);

            if (item.getStarred()) {
                imageView.setColorFilter(getColor(android.R.color.holo_orange_light));
                imageView.setImageResource(R.drawable.ic_star_black_24dp);

            } else {
                imageView.clearColorFilter();
                imageView.setImageResource(R.drawable.ic_star_border_black_24dp);
            }

            // Star cheese when the icon is clicked
            imageView.setOnClickListener(new ImageView.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.setStarred(!item.getStarred());
                    notifyDataSetChanged();
                }});

            return convertView;
        }
    }
}
