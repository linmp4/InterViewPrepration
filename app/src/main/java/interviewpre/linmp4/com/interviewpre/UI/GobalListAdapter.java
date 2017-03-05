package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.R;

public class GobalListAdapter extends BaseAdapter {

    private List<MainModel> data;
    private LayoutInflater layoutInflater;

    GobalListAdapter(Context context, List<MainModel> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView tv_title;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder zujian;
        if (convertView == null) {
            zujian = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_simple_list, null);
            zujian.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(zujian);
        } else {
            zujian = (ViewHolder) convertView.getTag();
        }

        final MainModel handData = data.get(position);

        zujian.tv_title.setText(handData.title);

        return convertView;
    }

}