package io.github.mobileteacher.attendanceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.mobileteacher.attendanceapp.models.Subject;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    RecyclerView subjectsList;
    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        subjectsList =  root.findViewById(R.id.recyclerview);

        Subject[] subjects = {new Subject("Projeto de Bloco Android", "Hallison Paz", "Seg", 60.0f),
                                new Subject("Segurança, Monetização e Publicação de Aplicativos Android", "John Edson", "Qua | Sex", 80.0f),
                                new Subject("Desenvolvimento Java Android", "Douglas Mattos", "Ter | Qui", 75.0f)};
        SubjectAdapter adapter = new SubjectAdapter(subjects);
        subjectsList.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                //new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        subjectsList.setLayoutManager(layoutManager);
        subjectsList.addItemDecoration(
                        new DividerItemDecoration(
                        getContext(), DividerItemDecoration.VERTICAL));

        return root;
    }

}
