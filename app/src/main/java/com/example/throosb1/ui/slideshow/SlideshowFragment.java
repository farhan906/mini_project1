package com.example.throosb1.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.throosb1.R;
import com.example.throosb1.databinding.FragmentSlideshowBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    TextView date;
    TextView link;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CalendarView calendarView = root.findViewById(R.id.calendarview);
        date = binding.date;
        link = binding.link1;
        date.setText(getFormattedTodayDate());

        // Set up the OnDateChangeListener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // Handle the selected date
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                date.setText(selectedDate);
//                Toast.makeText(requireContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();
            }
        });

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link.getText().toString()));

                // Check if there is an application available to handle the Intent
                if (intent.resolveActivity(requireContext().getPackageManager()) != null) {
                    // Start the activity to open the URL in the browser
                    startActivity(intent);
                } else {
                    // Handle the case where no application is available to handle the Intent
                    // (for example, show a toast or provide an alternative action)
                }
            }
        });

        return root;
    }

    public static String getFormattedTodayDate() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();

        // Create a SimpleDateFormat with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());

        // Format the current date and return the result
        return sdf.format(calendar.getTime());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}