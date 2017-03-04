package interviewpre.linmp4.com.interviewpre.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import interviewpre.linmp4.com.interviewpre.Model.MainModel;
import interviewpre.linmp4.com.interviewpre.R;

public abstract class GobalListAdapter extends BaseAdapter {

    private List<MainModel> data;
    private LayoutInflater layoutInflater;

    public GobalListAdapter(Context context, List<MainModel> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    private class ViewHolder {
        TextView tv_title;
        Button bt_code;
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
            zujian.bt_code = (Button) convertView.findViewById(R.id.bt_code);
            convertView.setTag(zujian);
        } else {
            zujian = (ViewHolder) convertView.getTag();
        }

        final MainModel handData = data.get(position);

        zujian.tv_title.setText(handData.title);

        if (handData.code == null) {
            zujian.bt_code.setVisibility(View.INVISIBLE);
        } else {
            zujian.bt_code.setVisibility(View.VISIBLE);
            zujian.bt_code.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClickCode(handData.code);
                }
            });
        }
        //绑定数据
        return convertView;
    }

    abstract void ClickCode(String code);
}