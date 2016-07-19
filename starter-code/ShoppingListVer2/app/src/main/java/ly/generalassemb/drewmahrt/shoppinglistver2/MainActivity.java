package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    private String TAG = this.getClass().getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBAssetHelper db = DBAssetHelper.getInstance(this);
        db.insert("Pizza", "They are soooo good!", "$4.00", "Frozen Food");
//        db.insert("Pizza1", "They are soooo good!", "$4.00", "Frozen Food");
//        db.insert("Pizza2", "They are soooo good!", "$4.00", "Frozen Food");
//        db.insert("Pizza3", "They are soooo good!", "$4.00", "Frozen Food");

// Find ListView to populate
        ListView lvItems = (ListView) findViewById(R.id.shopping_list_view);
// Setup cursor adapter using cursor from last step
        MyCursorAdapter myAdapter = new MyCursorAdapter(this, db.getData(),0);
// Attach cursor adapter to the ListView
        lvItems.setAdapter(myAdapter);
// Switch to new cursor and update contents of ListView
//        MyCursorAdapter.changeCursor(newCursor);
    }
}
