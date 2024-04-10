# MAD_Workshop-01-Develop-an-android-application-to-pass-the-data-between-the-activities-using-Intent.

## MainActivity.java:
```java
package com.example.mad_workshop1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText userNameEditText, ageEditText, emailEditText, contactNumberEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameEditText = findViewById(R.id.editTextUserName);
        ageEditText = findViewById(R.id.editTextAge);
        emailEditText = findViewById(R.id.editTextEmail);
        contactNumberEditText = findViewById(R.id.editTextContactNumber);
        submitButton = findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String contactNumber = contactNumberEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("AGE", age);
                intent.putExtra("EMAIL", email);
                intent.putExtra("CONTACT_NUMBER", contactNumber);
                startActivity(intent);
            }
        });
    }
}
```

## activity_main.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextUserName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginTop="216dp"
        android:hint="User Name" />

    <EditText
        android:id="@+id/editTextAge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextUserName"
        android:layout_alignParentStart="true"
        android:layout_marginStart="-2dp"
        android:layout_marginTop="7dp"
        android:hint="Age" />

    <EditText
        android:id="@+id/editTextEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextAge"
        android:layout_alignParentStart="true"
        android:layout_alignParentEnd="true"
        android:layout_centerInParent="true"
        android:layout_marginStart="-2dp"
        android:layout_marginTop="7dp"
        android:layout_marginEnd="-5dp"
        android:hint="Email" />

    <EditText
        android:id="@+id/editTextContactNumber"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextEmail"
        android:layout_alignParentStart="true"
        android:layout_alignParentEnd="true"
        android:layout_centerInParent="true"
        android:layout_marginStart="2dp"
        android:layout_marginTop="19dp"
        android:layout_marginEnd="1dp"
        android:hint="Contact Number" />

    <Button
        android:id="@+id/buttonSubmit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextContactNumber"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="67dp"
        android:text="Submit" />

</RelativeLayout>
```

## DisplayActivity.java:
```java
package com.example.mad_workshop1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView userNameTextView, ageTextView, emailTextView, contactNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        userNameTextView = findViewById(R.id.textViewUserName);
        ageTextView = findViewById(R.id.textViewAge);
        emailTextView = findViewById(R.id.textViewEmail);
        contactNumberTextView = findViewById(R.id.textViewContactNumber);

        Intent intent = getIntent();
        if (intent != null) {
            String userName = intent.getStringExtra("USER_NAME");
            String age = intent.getStringExtra("AGE");
            String email = intent.getStringExtra("EMAIL");
            String contactNumber = intent.getStringExtra("CONTACT_NUMBER");

            userNameTextView.setText("User Name: " + userName);
            ageTextView.setText("Age: " + age);
            emailTextView.setText("Email: " + email);
            contactNumberTextView.setText("Contact Number: " + contactNumber);
        }
    }
}
```
## activity_display.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DisplayActivity">

    <TextView
        android:id="@+id/textViewUserName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_marginTop="20dp"/>

    <TextView
        android:id="@+id/textViewAge"
        android:layout_below="@id/textViewUserName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_marginTop="20dp"/>

    <TextView
        android:id="@+id/textViewEmail"
        android:layout_below="@id/textViewAge"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_marginTop="20dp"/>

    <TextView
        android:id="@+id/textViewContactNumber"
        android:layout_below="@id/textViewEmail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_marginTop="20dp"/>

</RelativeLayout>
```

## AndroidManifest.xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    package="com.example.mad_workshop1">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MAD_workshop1"
        tools:targetApi="31">

        <!-- MainActivity declaration -->
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- DisplayActivity declaration -->
        <activity android:name=".DisplayActivity"/>

    </application>

</manifest>
```

# OUTPUT:
![image](https://github.com/selva258963/MAD-workshop-1/assets/120718823/8cc7a5af-beea-43b5-837f-f76db0d59541)
![image](https://github.com/selva258963/MAD-workshop-1/assets/120718823/4c066de9-6145-4605-9baf-6959e47fa84d)





