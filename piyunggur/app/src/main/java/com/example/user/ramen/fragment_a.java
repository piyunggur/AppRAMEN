package com.example.user.ramen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class fragment_a extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button buttonOk;

    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.test_fragment_a,container,false);
        editText = v.findViewById(R.id.edit_text_a);
        buttonOk = v.findViewById(R.id.button_ok_a);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        return v;
    }

    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof fragment_a) {
            listener = (fragment_a) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "must implement FragmentAlistener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }

}
