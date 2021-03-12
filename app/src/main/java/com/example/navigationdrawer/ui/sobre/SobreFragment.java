package com.example.navigationdrawer.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawer.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao = "A ATM consultoria tem como missão apoiar organizações "+
                "que desejam alcançar o sucesso através da excelencia em gestão e " +
                "pela busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em Contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um E-mail")
                .addWebsite("https://google.com/", "Acesse Nosso Site")

                .addGroup("Redes Sociais")
                .addFacebook("juliana.behringer", "Facebook")
                .addInstagram("julianabgr", "Instagram")
                .addTwitter("julianabgr", "Twitter")
                .addYoutube("julianabgr", "YouTube")
                .addPlayStore("com.facebook.katana", "Download App")

                .addItem(versao)

                .create();

       // return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
