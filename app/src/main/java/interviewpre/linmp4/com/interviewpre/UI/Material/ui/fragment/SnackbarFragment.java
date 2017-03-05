package interviewpre.linmp4.com.interviewpre.UI.Material.ui.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import interviewpre.linmp4.com.interviewpre.R;

public class SnackbarFragment extends Fragment {


    @Bind(R.id.flb_black)
    FloatingActionButton flbBlack;
    @Bind(R.id.flb_black2)
    FloatingActionButton flbBlack2;
    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snackbar, container, false);
        ButterKnife.bind(this, view);


        class MyClickListener implements View.OnClickListener {

            private int Dur;
            private String show;

            private MyClickListener(String show, int Dur) {
                this.show = show;
                this.Dur = Dur;
            }

            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout, show, Dur)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity(), "snackbar OK clicked", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setActionTextColor(Color.WHITE)
                        .setCallback(new Snackbar.Callback() {

                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                super.onDismissed(snackbar, event);
                                if (getActivity() != null)
                                    Toast.makeText(getActivity(), "Snackbar dismiss", Toast.LENGTH_SHORT).show();
                            }


                            @Override
                            public void onShown(Snackbar snackbar) {
                                super.onShown(snackbar);
                                if (getActivity() != null)
                                    Toast.makeText(getActivity(), "Snackbar show", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        }

        flbBlack.setOnClickListener(new MyClickListener("Snackbar_LENGTH_LONG", Snackbar.LENGTH_LONG));
        flbBlack2.setOnClickListener(new MyClickListener("Snackbar_LENGTH_INDEFINITE", Snackbar.LENGTH_INDEFINITE));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public String getcode() {
        return null;
    }
}
