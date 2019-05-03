package fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingshopping.MainActivity;
import com.example.onlineclothingshopping.R;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

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
        etRegisterPassword = view.findViewById(R.id.etLoginPassword);
        etRegisterConfirmPassword = view.findViewById(R.id.etRegisterConfirmPassword);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        registerUser();
    }

    private void registerUser(){
        String password = etRegisterPassword.getText().toString();
        String confirmPassword = etRegisterConfirmPassword.getText().toString();

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email", etRegisterEmail.getText().toString());
        editor.putString("password", etRegisterPassword.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_SHORT).show();
    }
}
