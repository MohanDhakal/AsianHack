package com.asianapp.mohankumardhakal.athithi.foodprediction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.asianapp.mohankumardhakal.athithi.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendImageToServerActivity extends AppCompatActivity {
    Button sendImage;
    ImageView chooseImage;
    Dialog dialog;
    Bitmap bitmap;
    private final int IMG_RQST = 1;

//    String postUri = "http://54.89.189.119:8090/check/cash/";
String postUri = "http://192.168.0.132:5000/check/cash/";

    public  void uploadImage(){
        Log.i("where", "here");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, postUri,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SendImageToServerActivity.this, "Server Message on Response" + response, Toast.LENGTH_SHORT).show();
                        Log.i("response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SendImageToServerActivity.this, "Error....", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                        Log.i("Error ", error.getMessage().toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("imageName",imageToString(bitmap));
                return params;
            }
        };
        MySingleton.getinstance(SendImageToServerActivity.this).addToRequestQueue(stringRequest);

    }
    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream );
        byte[]imgbytes=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgbytes, Base64.DEFAULT);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_image_to_server);
        sendImage = findViewById(R.id.sendData);
        chooseImage = findViewById(R.id.imageButton);
        //choosing image or upload image
        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
    //send Image to server
        sendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
                Log.i("Check", "checked");
            }
        });
    }

    /*private void showDialogBox() {
        dialog = new Dialog(SendImageToServerActivity.this, R.style.Dialog);
//        dialog.setTitle("Upload Image");
        //view to show
        View customView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_to_choose, null);

        //finding the views
        Button choose_image = customView.findViewById(R.id.upload);
        Button capture_image = customView.findViewById(R.id.capture);

        //accesing camera from capture image
        capture_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                chooseImage();
            }
        });
        dialog.setContentView(customView);
        dialog.setCancelable(false);
        dialog.show();

    }*/

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMG_RQST);
    }


    /*private void chooseImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 101);
        Intent intent1 = new Intent(Intent.ACTION_PICK);

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            if (requestCode ==IMG_RQST) {
                Uri path = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                    chooseImage.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
            }
        }

    }

/*

    public static byte[] getBlob(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bArray = bos.toByteArray();
        return bArray;
    }

*/
  /*  public void sendDataToServer() {
        Log.i("Where", "here");
        final String tags ="";
        //custom volley request
        ImageRequest imageRequest=new ImageRequest(postUri, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                Toast.makeText(SendImageToServerActivity.this, "Server Message on Response" + response, Toast.LENGTH_SHORT).show();
                Log.i("response", String.valueOf(response));

            }
        }, 100, 200, 1,, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SendImageToServerActivity.this, "Error....", Toast.LENGTH_SHORT).show();
                Log.i("Error ", error.getMessage().toString());

            }
        });*/

/*        StringRequest stringRequest = new StringRequest(Request.Method.POST, postUri,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(SendImageToServerActivity.this, "Server Message on Response" + response, Toast.LENGTH_SHORT).show();
                        Log.i("response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SendImageToServerActivity.this, "Error....", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                        Log.i("Error ", error.getMessage().toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("remarks", food_remarks);
                return params;
            }
        };

        MySingleton.getinstance(SendImageToServerActivity.this).addToRequestQueue(stringRequest);
    }*/
//    }
}
