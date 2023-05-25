package com.example.greenstore_manager.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.greenstore_manager.adapter.ListaComprasAdapter;
import com.example.greenstore_manager.databinding.FragmentGalleryBinding;
import com.example.greenstore_manager.model.Planta;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

    binding = FragmentGalleryBinding.inflate(inflater, container, false);
    View root = binding.getRoot();



        List<Planta> plantas = new ArrayList<>();

        ListaComprasAdapter adapterPlanta = new ListaComprasAdapter();
        adapterPlanta.setContext(getActivity());
        adapterPlanta.setListaPlantas(plantas);

        binding.RecyclerView .setAdapter(adapterPlanta);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}