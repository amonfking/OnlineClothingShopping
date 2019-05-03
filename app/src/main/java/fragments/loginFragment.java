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
import com.example.onlineclothingshopping.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class loginFragment extends Fragment implements View.OnClickListener{
    private Button btnLogin;
    private EditText etLoginEmail, etLoginPassword;

    public loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = view.findViewById(R.id.btnLogin);
        etLoginEmail = view.findViewById(R.id.etLoginEmail);
        etLoginPassword = view.findViewById(R.id.etLoginPassword);

        btnLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (validation()) {
            login();
        }
    }

    public void login(){
        SharedPreferences sharedPreference = this.getActivity().getSharedPreferences("user", MODE_PRIVATE);
        String email = sharedPreference.getString("email","");
        String password = sharedPreference.getString("password","");

        if (email.equals(etLoginEmail.getText().toString()) || password.equals(etLoginPassword.getText().toString())){
            Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getActivity(), "Login Error", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etLoginEmail.getText().toString())){
            etLoginEmail.setError("Please enter Username");
            etLoginEmail.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etLoginPassword.getText().toString())){
            etLoginPassword.setError("Please enter Password");
            etLoginPassword.requestFocus();
            flag = false;
        }
        return flag;
    }
}
