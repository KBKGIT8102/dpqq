package com.example.dp.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp.Model.House;
import com.example.dp.Model.HouseLab;
import com.example.dp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseFragment extends Fragment {
    private static final String ARG_HOUSE_ID = "house_id";
    private House house;
    private TextView TitleField;
    private ImageView image;

    public HouseFragment() {
        // Required empty public constructor
    }

    public static HouseFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt(ARG_HOUSE_ID, id);
        HouseFragment fragment = new HouseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int Id = (int)getArguments().getSerializable(ARG_HOUSE_ID);
        house= HouseLab.get(getActivity()).getHouse(Id);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_houses, container, false);
        TitleField = (TextView) v.findViewById(R.id.textHouse);
        TitleField.setText(house.getTitle());
        image=v.findViewById(R.id.pictureHouse);
        Picasso.with(getActivity()).load(house.getPicture_path()).into(image);
        return v;
    }

}
