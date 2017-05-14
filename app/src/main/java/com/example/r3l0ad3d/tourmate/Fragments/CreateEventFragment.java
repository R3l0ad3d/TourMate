package com.example.r3l0ad3d.tourmate.Fragments;


import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.r3l0ad3d.tourmate.ModelClass.Event;
import com.example.r3l0ad3d.tourmate.R;
import com.example.r3l0ad3d.tourmate.databinding.FragmentCreateEventBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateEventFragment extends Fragment {

    private FragmentCreateEventBinding binding;
    private Event eventObj;
    private String toDate,fromDate,currentDate;

    public CreateEventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_create_event, container, false);
        binding = DataBindingUtil.bind(view);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
        currentDate = formater.format(new Date(calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR),calendar.get(Calendar.DAY_OF_MONTH)));

        btnClick();
        return view;
    }

   public void btnClick(){
       binding.btnToDateCE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setDate("to");
           }
       });
       binding.btnFromDateCE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setDate("from");
           }
       });
       binding.btnCreateEventCE.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               eventObj = new Event(currentDate,binding.etEventPlaceCE.getText().toString(),toDate,fromDate,binding.etEstimatedBudgetCE.getText().toString());
               Toast.makeText(getContext(),""+eventObj.getEventPlace()+" "+eventObj.getEstimatedBudget(),Toast.LENGTH_LONG).show();
           }
       });
   }

    public void setDate(final String callFrom){
        Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yy");
        DatePickerDialog datePick = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String str = formate.format(new Date(year,month,dayOfMonth));
                if(callFrom.equals("from")){
                    binding.btnFromDateCE.setText(str);
                    fromDate=str;
                }else{
                    binding.btnToDateCE.setText(str);
                    toDate = str;
                }
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePick.show();
    }
}
