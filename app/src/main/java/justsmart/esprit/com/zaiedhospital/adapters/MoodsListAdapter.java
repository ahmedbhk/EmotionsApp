package justsmart.esprit.com.zaiedhospital.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import justsmart.esprit.com.zaiedhospital.MainPatientActivity;
import justsmart.esprit.com.zaiedhospital.R;
import justsmart.esprit.com.zaiedhospital.entities.Mood;

public class MoodsListAdapter extends ArrayAdapter<MoodsListDataModel> implements View.OnClickListener{

    private ArrayList<MoodsListDataModel> dataSet;
    Context mContext;


    // View lookup cache
    private static class ViewHolder {
        TextView moodLevel;
        TextView moodName;
        TextView moodDate;
        ImageView moodImage;
        LinearLayout layout;
    }

    public MoodsListAdapter(ArrayList<MoodsListDataModel> data, Context context) {
        super(context, R.layout.moods_list_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        MoodsListDataModel dataModel=(MoodsListDataModel)object;

        String message="";
        if (dataModel.getExp().length()>0)
            message= dataModel.getExp();
        else
            message="You did not explain your choice";
        ShowDialog(v,message);

//
//        Snackbar.make(v, dataModel.getExp(), Snackbar.LENGTH_LONG)
//                .setAction("No action", null).show();

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MoodsListDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder=null; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.moods_list_item, parent, false);
            //viewHolder.Item = (Layout) convertView.find(R.layout.banks_list_item);
            viewHolder.moodName = (TextView) convertView.findViewById(R.id.moodName);
            viewHolder.moodDate = (TextView) convertView.findViewById(R.id.moodDate);
            viewHolder.moodLevel = (TextView) convertView.findViewById(R.id.moodLevel);
            viewHolder.moodImage = (ImageView) convertView.findViewById(R.id.moodImage);
            viewHolder.layout = (LinearLayout) convertView.findViewById(R.id.moodItem);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MoodsListAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.moodLevel.setText(dataModel.getLevel());
        viewHolder.moodName.setText(dataModel.getName());
        viewHolder.layout=(dataModel.getLayout());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
        Date d=dataModel.getDate();
        try {
            d= sdf.parse(d.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewHolder.moodDate.setText(d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900)+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
        viewHolder.moodImage.setTag(position);
        viewHolder.moodImage.setOnClickListener(this);

        viewHolder.moodLevel.setTag(position);
        viewHolder.moodLevel.setOnClickListener(this);

        viewHolder.moodName.setTag(position);
        viewHolder.moodName.setOnClickListener(this);

        viewHolder.moodDate.setTag(position);
        viewHolder.moodDate.setOnClickListener(this);

        viewHolder.layout.setTag(position);
        viewHolder.layout.setOnClickListener(this);
        Log.d("layoutTag",viewHolder.layout.getTag()+"");

//        viewHolder.BankLogo.setTag(position);
//        viewHolder.BankLogo.setImageBitmap(dataModel.getLogo());
        int imageId=0;
        switch (dataModel.getName()) {
            case "angry": {
                imageId=R.drawable.angry;
                break;
            } case "sad": {
                imageId=R.drawable.sad;
                break;
            } case "happy": {
                imageId=R.drawable.happy;
                break;
            } case "fearful": {
                imageId=R.drawable.fearful;
                break;
            } case "bored": {
                imageId=R.drawable.bored;
                break;
            } case "depressed": {
                imageId=R.drawable.depressed;
                break;
            } case "worried": {
                imageId=R.drawable.worried;
                break;
            } case "lonely": {
                imageId=R.drawable.lonely;
                break;
            } case "ashamed": {
                imageId=R.drawable.ashamed;
                break;
            } case "panicking": {
                imageId=R.drawable.panicking;
                break;
            } case "neutral": {
                imageId=R.drawable.neutral;
                break;
            }
            default: imageId=R.drawable.neutral;
        }


        viewHolder.moodImage.setImageDrawable(mContext.getResources().getDrawable(imageId));
        return convertView;
    }

    public static void ShowDialog(View v, String message)
    {
        final View view=v;
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(v.getContext());
        final LayoutInflater inflater = (LayoutInflater) MainPatientActivity.mActivity.getSystemService( MainPatientActivity.mActivity.LAYOUT_INFLATER_SERVICE);
        final View viewLayout = inflater.inflate(R.layout.dialog_layout_history,(ViewGroup)  MainPatientActivity.mActivity.findViewById(R.id.forDialog));
        SeekBar level ;
        //popDialog.setIcon(android.R.drawable.btn_star_big_on);
        popDialog.setTitle("Explanation ");

        popDialog.setView(viewLayout);
        final TextView tvLevel= (TextView) viewLayout.findViewById(R.id.explanation);
        tvLevel.setText(message);


        // Button OK
        popDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        popDialog.create();
        popDialog.show();

    }
}