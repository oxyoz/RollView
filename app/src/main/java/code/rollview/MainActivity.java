package code.rollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RollView mRollView;

    private List<View> mViews;

    String strs[] = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
            "cccccccccccccccccccccccccccccccccccccccccccccccccccccccc",
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mRollView = (RollView) findViewById(R.id.rollView);

        mViews = new ArrayList<View>();

        for (String str : strs)
        {

            TextView txtview = (TextView)getLayoutInflater().inflate(R.layout.item_text, null);

            txtview.setTag(str);

            txtview.setText(str);

            txtview.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    Toast.makeText(getBaseContext(), (String)v.getTag(), Toast.LENGTH_LONG).show();

                }
            });

            mViews.add(txtview);

        }

        mRollView.setAdapter(mViews).setDelayed(10000).start();

    }


}
