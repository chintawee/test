package com.example.kongkarat.chintawee.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragent extends Fragment {//ต้อง extends Fragment
    @Nullable
    @Override
    //เพื่อดึงหน้านั้นๆมาใช้
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_page/*ชื่อหน้าที่เรียก*/, container,false);
    }

    @Override
    //เพื่อให้เขียนโค้ด
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //ทำการเรียกใช้สิ่งที่อยู่หน้า layout

        Button button = getView().findViewById(R.id.button_first);
//        Log.d("error","poon");

        /*ไว้เรียกปุ่มกด*/button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = getView().findViewById(R.id.first_edit_fragent);
                String name2 = name.getText().toString();/*เปลี่ยนให้เป็นstring*/
//                String[] list = name2.split("");//loopเเช็คสเปส
//                String abc = "BCDEFGHIJ";
//                boolean poon = true;
//                boolean poon1 = false;
//                for (int i=0; i<list.length; i++)
//                {
//                    if (list[i] == " ")
//                    {
//                        poon = false;
//                    }
//                    if(name2.toUpperCase().charAt(i)<90&&name2.toUpperCase().charAt(i)>65){
//                        poon1 =  true;
//                    }
//                }

                if(name2.length()<3)//เช็คจำนวน
                {
                    Toast.makeText(getActivity(),"ใส่มากกว่าตัว", Toast.LENGTH_SHORT).show();
                }
                else if (name2.isEmpty())//เช็คว่าง
                {
                    Toast.makeText(getActivity(),"อย่าปล่อยว่าง", Toast.LENGTH_SHORT).show();
                }
                else if(name2.charAt(0)/*ใช้หาindexของstring*/!= name2.toUpperCase().charAt(0))
                {
                    Toast.makeText(getActivity(),"ตัวแรกต้องตัวใหญ่", Toast.LENGTH_SHORT).show();
                }
//                else if (poon = false)
//                {
//                    Toast.makeText(getActivity(),"ห้ามเว้นวรรค", Toast.LENGTH_SHORT).show();
//                }
//                else if(poon1 = false)
//                {
//                    Toast.makeText(getActivity(),"ห้าม", Toast.LENGTH_SHORT).show();
//                }
                else
                {
                    getFragmentManager().beginTransaction().replace(R.id.main_page, new MenuFragement()).commit();
                }
            }
        });
    }
}
