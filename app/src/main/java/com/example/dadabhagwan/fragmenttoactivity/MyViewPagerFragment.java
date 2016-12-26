package com.example.dadabhagwan.fragmenttoactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyViewPagerFragment extends Fragment {


    public MyViewPagerFragment() {
        // Required empty public constructor
    }

    public static MyViewPagerFragment newInstance(int pos,int imgId)
    {
       MyViewPagerFragment myViewPagerFragment=new MyViewPagerFragment();

        Bundle bundle=new Bundle();
        bundle.putInt("pos",pos);
        bundle.putInt("imgid",imgId);
        myViewPagerFragment.setArguments(bundle);

        return myViewPagerFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int imgid=getArguments().getInt("imgid");
        int pos=getArguments().getInt("pos");
        View view= inflater.inflate(R.layout.fragment_my_view_pager, container, false);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageForViewPager);
        imageView.setImageResource(imgid);
        Toast.makeText(getActivity(), "Page number"+pos, Toast.LENGTH_SHORT).show();
    return view;
    }

}
