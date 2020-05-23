package com.talla.morningnewstelugu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.talla.morningnewstelugu.ViewModels.PdfViewModel;
import com.talla.morningnewstelugu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    private View view;
    private PdfViewModel pdfViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        view=binding.getRoot();
        setContentView(view);
        pdfViewModel= ViewModelProviders.of(this).get(PdfViewModel.class);
    }

    public void readNews(View view)
    {
        binding.progressbar.setVisibility(View.VISIBLE);
        pdfViewModel.loadPdfOnline(binding);
    }
}
