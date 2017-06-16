package com.example.android.inventory;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.inventory.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFragment newInstance(int columnCount) {
        ListFragment listFragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        listFragment.setArguments(args);
        return listFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new ItemAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(String type);
    }
}

/* code from https://forums.bignerdranch.com/t/using-a-recyclerview-with-a-loader-cursorloader/8286/3
 public class MyFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
      private final static int LOADER_ID = 0;
      .......

   @Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    getLoaderManager().initLoader(LOADER_ID, null, this);
}
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        //Setup the uri that will get the data I need from my ContentProvider
        Uri loaderUri = RecordingsContract.Shows.BY_DATE_URI;
        //and get a CursorLoader from my contentprovider
        return new CursorLoader(getActivity(), loaderUri, SHOWS_PROJECTION, null, selectionArgs, RecordingsContract.Shows.DATE + " desc");
    }
    @Override
public void onLoadFinished(Loader loader, Cursor c) {

    //When the loader has loaded some data (either initially, or the
    //datasource has changed and a new cursor is being provided),
    //Then we'll swap out the curser in our recyclerview's adapter
    // and we'll create the adapter if necessary
    if (mShowsAdapter == null) {
        mShowsAdapter = new ShowAdapter();
        mShowList.setAdapter(mShowsAdapter);
    }

    mShowsAdapter.swapCursor(c);
}

@Override
public void onLoaderReset(Loader loader) {
    //If the loader is reset, we need to clear out the
    //current cursor from the adapter.
    mShowsAdapter.swapCursor(null);
}

  */