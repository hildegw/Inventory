package com.example.android.inventory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    // the fragment initialization parameters, just the inventory item type
    private static final String ARGUMENT_TYPE = "type";

    //private OnDetailsFragmentInteractionListener mListener; todo: remove if no interaction is needed

    public DetailsFragment() {
        // Required empty public constructor
    }

    //instantiate Fragment
    public static DetailsFragment newInstance(String type) {
        final Bundle args = new Bundle();
        args.putString(ARGUMENT_TYPE, type);
        final DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    //todo query DB for description, price, quantity, re-order email, image


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_details, container, false);
        final TextView typeTextView = (TextView) view.findViewById(R.id.type);
        final TextView descriptionTextView = (TextView) view.findViewById(R.id.description);
        final TextView priceTextView = (TextView) view.findViewById(R.id.price);
        final ImageView imageView = (ImageView) view.findViewById(R.id.image);
        final TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        final Button plusButton = (Button) view.findViewById(R.id.plus_button);
        final Button minusButton = (Button) view.findViewById(R.id.minus_button);
        final Button reorderButton = (Button) view.findViewById(R.id.reorder_button);

        final Bundle args = getArguments();
        typeTextView.setText(args.getString(ARGUMENT_TYPE));
        return view;
    }

    /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onDetailsFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDetailsFragmentInteractionListener) {
            mListener = (OnDetailsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *
    public interface OnDetailsFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDetailsFragmentInteraction(Uri uri);
    }*/
}
