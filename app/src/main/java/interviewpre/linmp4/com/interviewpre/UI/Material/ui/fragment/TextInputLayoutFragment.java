package interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import interviewpre.linmp4.com.interviewpre.R;

public class TextInputLayoutFragment extends Fragment {

    @Bind(R.id.tl_text_password)
    TextInputLayout tl_text_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_textinputlayout, container, false);
        ButterKnife.bind(this, view);

        tl_text_password.setHint("请输入密码(TextInputLayout.setHint)");
        tl_text_password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这儿判断操作，如果输入错误可以给用户提示
                if (s.length() != 0 && s.length() < 5) {
                    tl_text_password.setErrorEnabled(true);
                    tl_text_password.setError("密码不能小于6位(TextInputLayout.setError_Enabled)");
                } else {
                    tl_text_password.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

}
