package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    ListView mList;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList= (ListView) findViewById(R.id.shopping_list_view);
        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        ShoppingListSQLiteHelper helper = ShoppingListSQLiteHelper.getInstance(MainActivity.this);
        mCursor= helper.getShoppingList();


        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, mCursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.shopping_list_items, parent, false);

            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {


                TextView textView= (TextView)view.findViewById(R.id.textView1);
                TextView textPrice= (TextView)view.findViewById(R.id.textView2);
                TextView textDescription= (TextView)view.findViewById(R.id.textView3);
                TextView textType= (TextView)view.findViewById(R.id.textView4);

                String itemName= cursor.getString(cursor.getColumnIndex("ITEM_NAME"));
                String itemPrice= cursor.getString(cursor.getColumnIndex("PRICE"));
                String itemDescription= cursor.getString(cursor.getColumnIndex("DESCRIPTION"));
                String itemType= cursor.getString(cursor.getColumnIndex("TYPE"));

                textView.setText(itemName);
                textPrice.setText(itemPrice);
                textDescription.setText(itemDescription);
                textType.setText(itemType);

            }

        };mList.setAdapter(cursorAdapter);

    }




}
