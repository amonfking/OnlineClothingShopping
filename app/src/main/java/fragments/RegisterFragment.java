package fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingshopping.DashboardActivity;
import com.example.onlineclothingshopping.MainActivity;
import com.example.onlineclothingshopping.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private EditText etRegisterName, etRegisterEmail, etRegisterPassword, etRegisterConfirmPassword;
    private Button btnRegister;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        etRegisterEmail = view.findViewById(R.id.etRegisterEmail);
        etRegisterName = view.findViewById(R.id.etRegisterName);
        etRegisterPassword = view.findViewById(R.id.etRegisterPassword);
        etRegisterConfirmPassword = view.findViewById(R.id.etRegisterConfirmPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    registerUser();
                }
            }
        });
        return view;
    }


    private void registerUser(){
        String name = etRegisterName.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();
//        String confirmPasssword = etRegisterConfirmPassword.getText().toString();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password",password);
        editor.commit();

        Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), DashboardActivity.class);
        startActivity(intent);

    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etRegisterName.getText().toString())){
            etRegisterName.setError("Please enter name");
            etRegisterName.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etRegisterEmail.getText().toString())){
            etRegisterEmail.setError("Please enter email");
            etRegisterEmail.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etRegisterPassword.getText().toString())){
            etRegisterPassword.setError("Please enter Password");
            etRegisterPassword.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etRegisterConfirmPassword.getText().toString())){
            etRegisterConfirmPassword.setError("Please enter Confirm Password");
            etRegisterConfirmPassword.requestFocus();
            flag = false;
        }

        return flag;
    }
}
