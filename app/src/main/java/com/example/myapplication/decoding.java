package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.zackratos.ultimatebarx.ultimatebarx.java.UltimateBarX;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class decoding extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    MaterialButton materialButton;
    TextView textView,textView2;
    Context context = this;
    data data = new data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoding);
        materialButton = findViewById(R.id.submit);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.t);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textView);
        materialButton.setOnClickListener(decoding.this);
        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", context.MODE_PRIVATE);
        boolean clip = sp.getBoolean("clip", Boolean.parseBoolean(""));
        if(clip == true) {
            if(data.getDocode() == (String) getText(R.string.decode_fail) || data.getDocode() == null) {
                textView.setTextIsSelectable(false);
                textView2.setTextIsSelectable(false);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            } else {
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipBorader.ClipBorader(context,data.getDocode());
                        Toast.makeText(context,R.string.clip_decode,Toast.LENGTH_SHORT).show();
                    }
                });
                textView.setTextIsSelectable(true);
                textView2.setTextIsSelectable(true);
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipBorader.ClipBorader(context,data.getTranslate());
                        Toast.makeText(context,R.string.clip_translate,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if (clip == false || data.getDocode() == (String) getText(R.string.decode_fail) || data.getDocode() == null) {
            textView.setTextIsSelectable(false);
            textView2.setTextIsSelectable(false);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        if(this.getApplication().getResources().getConfiguration().uiMode == 0x21) {
            UltimateBarX.statusBar(this).transparent().light(false).apply();
            UltimateBarX.navigationBar(this).transparent().light(false).apply();
        } else {
            UltimateBarX.statusBar(this).transparent().light(true).apply();
            UltimateBarX.navigationBar(this).transparent().light(true).apply();
        }
    }
    @Override
    protected void onPause() {
        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", context.MODE_PRIVATE);
        boolean clip = sp.getBoolean("clip", Boolean.parseBoolean(""));
        if(clip == true) {
            if(data.getDocode() ==  getText(R.string.decode_fail)) {
                textView.setTextIsSelectable(false);
                textView2.setTextIsSelectable(false);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            } else {
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipBorader.ClipBorader(context,data.getDocode());
                        Toast.makeText(context,R.string.clip_decode,Toast.LENGTH_SHORT).show();
                    }
                });
                textView.setTextIsSelectable(true);
                textView2.setTextIsSelectable(true);
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ClipBorader.ClipBorader(context,data.getTranslate());
                        Toast.makeText(context,R.string.clip_translate,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if (clip == false || data.getDocode() == (String) getText(R.string.decode_fail) || data.getDocode() == null) {
            textView.setTextIsSelectable(false);
            textView2.setTextIsSelectable(false);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        super.onPause();
    }
    @Override
    protected void onRestart() {
        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", context.MODE_PRIVATE);
        boolean clip = sp.getBoolean("clip", Boolean.parseBoolean(""));
        Log.e("tsoashao",String.valueOf(data.getDocode()));
        Log.e("bodahdais",(String) getText(R.string.decode_fail));

        if(clip == true) {
           if(data.getDocode() == getText(R.string.decode_fail) || data.getDocode() == null) {
               textView.setTextIsSelectable(false);
               textView2.setTextIsSelectable(false);
               textView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                   }
               });
               textView2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                   }
               });
           } else {
               textView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       ClipBorader.ClipBorader(context,data.getDocode());
                       Toast.makeText(context,R.string.clip_decode,Toast.LENGTH_SHORT).show();
                   }
               });
               textView.setTextIsSelectable(true);
               textView2.setTextIsSelectable(true);
               textView2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       ClipBorader.ClipBorader(context,data.getTranslate());
                       Toast.makeText(context,R.string.clip_translate,Toast.LENGTH_SHORT).show();
                   }
               });
           }
        } else if (clip == false || data.getDocode() == (String) getText(R.string.decode_fail) || data.getDocode() == null) {
            textView.setTextIsSelectable(false);
            textView2.setTextIsSelectable(false);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        super.onRestart();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId=item.getItemId();
        switch (itemId) {
            case R.id.encode:
                Intent encode = new Intent(this,encoding.class);
                startActivity(encode);
                break;
            case R.id.decode :
                Intent decode = new Intent(this,decoding.class);
                startActivity(decode);
                finish();
                break;
            case R.id.settings :
                Intent settings = new Intent(this,SettingsActivity.class);
                startActivity(settings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        String pcode = editText.getText().toString();
        Log.e("fesnihf",String.valueOf(data.getDocode()));
        Log.e("npsdish",(String) getText(R.string.decode_fail));
        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", context.MODE_PRIVATE);
        try {
            String decode = new String(Base64.decode(pcode.getBytes(), Base64.DEFAULT));
            boolean clip = sp.getBoolean("clip", Boolean.parseBoolean(""));
            boolean status = sp.getBoolean("translate", Boolean.parseBoolean(""));
            int result = decode.indexOf("�") & decode.indexOf("~\u0018");
            if (result == 1 || result == 0 || result == 2) {
                textView.setText(R.string.decode_fail);
                data.setDocode((String) getText(R.string.decode_fail));
                textView2.setText("");
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                textView.setTextColor(Color.RED);
                textView.setTextIsSelectable(false);
            } else {
                if (decode == null || decode.equals(" ") || decode.equals("")) {
                    textView.setText(getText(R.string.decode_fail));
                    data.setDocode((String) getText(R.string.decode_fail));
                    textView2.setText("");
                    textView.setTextColor(Color.RED);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                    textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                } else {
                    textView.setText(getText(R.string.decode_after) +" " + decode);
                    if(sp.getBoolean("clip", Boolean.parseBoolean("")) == false) {
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                    } else {
                        textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ClipBorader.ClipBorader(context,decode);
                                Toast.makeText(context,(String)getText(R.string.clip_decode),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    data.setDocode(decode);
                    apiKey apiKey = new apiKey();
                    String string = apiKey.getAppid()+decode+apiKey.getSalt()+apiKey.getKey();
                    String md5 = stringToMD5.stringToMD5(string);
                    String objT = sp.getString("translate_list","");
                    if(status == true && objT != "")  {
                        String url = "http://api.fanyi.baidu.com/api/trans/vip/translate?q="+decode+"&from=auto&to=zh&appid="+apiKey.getAppid()+"&salt="+apiKey.getSalt()+"&sign="+md5;
                        sendRequestWithOKHttp2(url);
                        textView.setText(getText(R.string.decode_after) +" " + decode);
                        data.setDocode(decode);
                    } else {
                        if (objT == "") {
                            textView.setText("");
                            textView2.setText("");
                        }
                        if(sp.getBoolean("clip", Boolean.parseBoolean("")) == false) {
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            });
                        } else {
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ClipBorader.ClipBorader(context,decode);
                                    Toast.makeText(context,(String)getText(R.string.clip_decode),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        textView.setText(getText(R.string.decode_after) +" " + decode);
                        data.setDocode(decode);
                        textView2.setText("");
                    }
                    int dcolor = textView2.getCurrentTextColor();
                    if(this.getApplication().getResources().getConfiguration().uiMode == 0x21) {
                        textView.setTextColor(dcolor);
                    } else {
                        textView.setTextColor(dcolor);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            textView.setText(R.string.decode_fail);
            textView2.setText("");
            textView.setTextColor(Color.RED);
            data.setDocode((String) getText(R.string.decode_fail));
            textView.setTextIsSelectable(false);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
    public void sendRequestWithOKHttp2(String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(url).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJsonWithGson(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void parseJsonWithGson(String json) {
        try {
            JSONObject jsonObject1 = new JSONObject(json);
            JSONArray jsonArray = jsonObject1.getJSONArray("trans_result");
            JSONObject jsonObject = (JSONObject) jsonArray.get(0);
            String name = jsonObject.getString("dst");
            showResponse(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showResponse(String name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", context.MODE_PRIVATE);
                textView2.setText(getText(R.string.translate_after)+" "+name);
                data.setTranslate(name);
                if (sp.getBoolean("clip", Boolean.parseBoolean("")) == false) {
                    textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    });
                } else {
                    textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ClipBorader.ClipBorader(context,name);
                            Toast.makeText(context,getText(R.string.clip_translate),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}