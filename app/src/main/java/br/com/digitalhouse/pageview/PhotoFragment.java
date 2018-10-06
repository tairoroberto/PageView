package br.com.digitalhouse.pageview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoFragment extends Fragment {

    public static PhotoFragment newInstance(int image, String text) {

        Bundle args = new Bundle();
        args.putInt("IMAGE", image);
        args.putString("TEXT", text);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        ImageView photo = view.findViewById(R.id.imageView);
        TextView text = view.findViewById(R.id.textView);
        photo.setImageResource(getArguments().getInt("IMAGE"));
        text.setText(getArguments().getString("TEXT"));

        return view;
    }
}
