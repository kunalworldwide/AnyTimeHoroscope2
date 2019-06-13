package pwapps.anytimehoroscope.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import pwapps.anytimehoroscope.Fragments.OfflineFragment;
import pwapps.anytimehoroscope.R;
import pwapps.anytimehoroscope.Sign;

public class OfflineSignAdapter extends ArrayAdapter<Sign> {

    private final Activity context;
    private final ArrayList<Sign> signArrayList;

    public OfflineSignAdapter(Activity context , ArrayList<Sign> signArrayList){

        super(context,R.layout.offline_sign_layout,signArrayList);

        this.context = context;
        this.signArrayList = signArrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fragmentListView = layoutInflater.inflate(R.layout.offline_sign_layout,null,false);

        Sign signArrayList = getItem(position);

        TextView title = fragmentListView.findViewById(R.id.sign_title);
        title.setText(signArrayList.getTitle());

        TextView shortDesc = fragmentListView.findViewById(R.id.sign_description);
        shortDesc.setText(signArrayList.getShortDescription());

        ImageView logo = fragmentListView.findViewById(R.id.sign);
        logo.setImageResource(signArrayList.getLogo());

        return fragmentListView;

    }


}
