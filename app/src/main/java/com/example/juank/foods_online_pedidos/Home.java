package com.example.juank.foods_online_pedidos;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.juank.foods_online_pedidos.servicios.MyService;

public class Home extends AppCompatActivity {

    String nombre,direccion;
    TextView campo;
    EditText colorearCampo;
    Colorear obj;
    Button task;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Cliente clienteRecibido = (Cliente) getIntent().getSerializableExtra("cliente");

        Bundle recibido=getIntent().getExtras();
        int salraio = recibido.getInt("salario");
        Cliente cliente2 = (Cliente) recibido.getSerializable("cliente");
        campo=findViewById(R.id.camposRecibidos);
        campo.setText("Nombre: "+clienteRecibido.getNombre()+" direccion: "+clienteRecibido.getDireccion()+" Salario: "+salraio+" nombre2: "+cliente2.getNombre());
        //clienteRecibido.ge
        colorearCampo = findViewById(R.id.campo2);
        task = findViewById(R.id.botonTask);
        image = findViewById(R.id.image);
    }
    public void colorear(View vistax){
        //Glide.with(this).load("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQAAAADFCAMAAACM/tznAAAAsVBMVEX///8Aj08AjUsAhz8AiUMAjkwAiEAAikQAi0f8/PwAhjwAhTz4+Pj7/v309PTd3d3q9fDo6Oibmprj4+OnpqZycHGMi4uv1cHx+PXPz89jr4bj8eopmF+joqJ9e3zU09PH49WRkJC9vL2o0buezLNiYGFosYmHhYbR6NxQpni73Mu1tLRNpnfGxcWFv59ubG0hlls+n2t9u5lJR0iPxKfZ7eNdW1xTUVIAgS85NjY3nWeXzaGcAAANfUlEQVR4nO2dC3eiPBOAI3dQQW4qWlG0ikrxttrdr///h30JCQgaaz2nrcCbZ3dbgcCSSTKZZCYRAAaDwWAwGAwGg8FgMBgMBoPBYDAYDAaDwWAwGAzG99IeTibrXm89WQ7bz36X3+bUO+wbktbkJUGQeE2TXxaz07Nf6rfo9AZyU1A4sZFDVITm7jh89rv9ApOVIikNKqIgrOpeDWYvTY6ee4zSHHSe/Y4/yHrHi59lPxEBP3v2a/4U/ZV2N/uI5qCefcKEu9H0r5Bf6tgMZl8rftwMGvWTwFH7cvYhXKP/7Bf+Zh7LP5TAS730wPrB/EM9MHj2O38nHf7R/DcateoN97eMH5HjFAhH049afRThK70CcALf2A8Wh8XibccLVzJQVs9+7++i36AVMMd/vHZSTdceHl+ky1Ta5Jlv/Y28CpS6r71NLpKtGxeGErd/xtv+ABQFILxMKAkXF02lSUtUPdZXGkBsbuhJj8WkXD20wOByCMApk1tpD8XWItSiI5Av89/4ZN7no9BehNffe80fY3lhBIqfDnSGhdTcx6+95s9xvKgBzeWnyQ+FBqPVYEx0oQKE4+fJhwUtIK1/5yV/kqIZLO7upX/Lp1cOv/GKP0q7aAbeL9Jevivk3n7jHX+UfqEFiI27w/yO8Fj6stOR8gJQFvfv+MhXGanyWrAoAOELg/yC1mxW3ldUFMBXrPtjQQCfd5oVoF8wA7Qv5Gf2Tzrzr/Kusn7jUQH0T6fTMOPn3/CnKei0mgxwH2KVN2yE3rNf5/cp6LQaWHYPM2nmBHAe3q17kBltYNhbDeCfhDf6wKFNqIiNUDAFpVSrfWiSIPyjjPfbDYVLaRKz4UNMQDPosiwLsHfQeJ7/VxHfSWGAK6dlmrQM8eU6+TFnCpMZoWG+ElFqU8m5MO7J2WWSKf5qbHTKpU6nhS+nFIgsK9NFFvwiUtoPiKh7vB4dv+Q6DZ6kfaE6jirUoeSH+FkVwMUqX4yOVko+KR4KTmiOpcsbS01hlkciio8MEvi8om+v8inTyaMVJbKEuzuxUiqO+RERR3qvBc4Xv8h6s8muOHmAL1BVoFCxMUK+ZcvEGOoQ1aY0jig3/fVFDFXqH19QKoBWNd/5KT/bzZMRUeoHEuWmLCoaX3ShKaQLGFJiKyqlADCbXOPOVP/NsAGUSCFW4uo6Eber3kRZe5er3kLWCG4HjqXjxmvPIrxWMQWQMMnX5NTzv7wZOJr28rTYAr6aDrO8RZzV76VMbQWillqIlC5QqcgQ4JK2kitL7oO04uELJXpC2KUTR5TgGnFXkUHgFYXWLGeu/41wYekr0iHVcRNKD/CVWbWSUqjOUtaTDTdSk8SJiZzSlA7ZIGcpXeefv+NbLDOdQnvnc335ZLPawZG+slttJrmzlPKvduhYr2DUCm+FxoymeAqpXyn5FyseQ1zw/DaU3SfNuTOgjQGrHjnXKRaqqG1umHT9o0BbXFBlBYB5vVBrsny8rtOd9UKjzgEpNQgcvDL/BWXQOweM9pezw4t8Y1WZKFZbASScrlu2wku7t8FisVjtd0pTUG6OD+rhVtpQLD8SNM5Rg8Yz+BvRlVVj9+m6wdvUQQEkXMYNfhW5BgoAc6Bq+Hs0axAwR2hTlw/cQaiTV5Vm49+hNksHMLR53s+RaxE2ntF/VAtUyQ32JXpUd+9NaqUAMDRv100q4wd/gM4jAqiOH/wBbiwlpFE7BYD5zCtULP/qucG+BM3lR4OjRNHUgyNtWEipAFV0g32Nl680gsr5wR9g+QU9WFcFgKHOjRSooh/8AQoucyp8fRVAwr1hYbOafvAH+HxYWFU/+APQt1Yg1GDF2H0+212mwn7wB7i9v1CdLYA8NyTA1WHV8NeYydeakGvu6zgEvsFw1Sy4wziZ3/9nih9zOjQ0XpAVWZCamvx2rLn5Q2U4mR2Px9fe5D9U9RkMRm3Ro/STrUetcXYQA925SmT7oR/Dw+nFQ1SYNEgPHL+rXlwffeMLfzdmoJqxCsYeCGO79a6bwFRBrMPfUw/otofSeJ4FDPTJGwFVRYe6qprJqdiAZ21ggHEEdPQgMLbA2NFbwISHiSBbtmEA+Fm1x3fe5SmY1ngb+/Fo6oVx1343XRCY27EbR1Y0mlqWA8vWcUZWPIotmLn5yDLh4Whk6KHXjZzuuGsE03Dsx9Y0mPpxCGvDNozByFD9qeuFRuB1x+9j13Y91/4TPzuzNKAAYrBtuaHumEHLBz6wjC7MauQC4I90E9bsLWiNwsDyYVlbpg0Pdcex9aDbQidgzmCmu/DAjcYAftaB6ViODcKpAR8QWn4cAT+yQeCVsyGYgTcFW88wQsfo6lt1C1xzC0bTyDcNy0oE0LXH1miMVAKs+7ratT0r8owwik1rrlqeq8Pa43i6G3lIAHFXteE1w59GLX86VR0vAq7ngK1hPTuvVPTYNECkwrzajqdG4ziIWrBWm2M9sIDX0mG1VS3HA1ZgoupiWVNgOWM1gLkdWTqs+YYeOABW+kA3oN6AT5yGltqC16cBvMUJDPj8KYgCQ/eenddfJiqlzruk3cGkx51kN5DTOcyrM+m9vkLDvzaBXxe8aslKfyWd02vwyYYwxMvbnu1l9M0agsQrq0lyqr9Kt0xYrd7gX8h+AwaYXHzk4g0l2KOQaZQeJSvlwHkmFCc18epvsm58ssutkOS0FUrUkc+bJhDkBdjwSI6Kls2N9rXkEposXOKPXDkXUMyIy4cmgNm/4kSwgjYR71y7CZUFGJLl1Vkhz5ITScBINqGulXH83LstgGwaWORIplEZ0gVA1lec3QN4ESnaZ/O8O5FcxiUEtwXQF3H5c8LH6kPA2W6uMwEogizDvwh+kK0zU4iu7ONUAjzsZesOxDK6D4kAxGsBkKAAZY9mvYb7pB5zuzRr0gz3F0kX0s9iStM2gOXBoQqB40uSH2UMoqfXALSJEg4QzMK+XhSFbzZWHSKAqx1FNkq+DQw4UmHACYfZJU2kjHsuriVaDYACIKvo+UmacH9YI2vhlgBIHA3ecqGdJEq24EgEw60myf9TwiCyGwKYpVWDu7yhjzWD8LpcLicY7BfDahA7SfBTFWQWpM/TSqoGiQC4KwHgKn29exARQENoYjRNw9HRuNnjNoBXX6OQAexWl4a4W8i2ZSkPRACZJfiRCgDn4Tr0u3/lJE63FcfdvYCeJGfqI8k3egruDK43I3o2ZN+bmwK4Ulu3BbCR0zaAV5pIs3T/GVTzOwUlWR7uCeAq9je1axQhpUlqyQk3/EXaApA+xN9XoKGeFOuI0n0ZBxGAnAmAIwJ4TcrzvH1U+4h1HRGAcujNZj1MWq1xjw8flQQUJbvSJioFK5J1VhlKBQmAk64MISKZbK/cpdZUFr1OKgBaY8ZqkF/jHhSNg/BDxI/DYrHApsH97ap/GbJDUNrdD/GhNoHDOazT0vBnNKRRJG3Wvi0AbA0qh1clzSkZByWb6xETunTWIC5ybo+rANkoGJU7XieQ7rBPRkba8JMaQNr+Lnkkqut9yq4KpVODZMMUZTc7ndZ7+azXyaJBjns9DZcHYi68pU1AmPXRKKC4nyyxBsVU281o4ZVlW1M0TPeIEvgmGfORmKf0OzRkvsmTIT1U52kvIPMp0BZKFcV504Gk/yRx9jyxmYihUDY1eL37A4/X/bT3lwEx2vFy82GS21QA56EvGk+mm3KlFvOBNKrn5ZXO5uLbBbU06rn9UWzDGhIMbS1lJoB2JjJkW28ubB8yMCydGgQ9jk+/QkzkJCkX87bhJSW9wCtJh0ARgKhkU8bpFkxoT950iuC8jGZ3MW1UGtrrxb6hyIKs7Aazwvx3fzZ44WRBgBd6uJ9oi5JAZoJkWcGc9dpJE5KraJ/x3r/kY872O0ocx4li6azBhHYfQbuSXGgXD8+0i7elp88fc9Ng7etTz8dTgW6gD/oYADV15oxb8IcxyjmzWuS3buPb0A+U3IMXDB3dop5TJyeAge6xR6X0CZ/ZtgD2WiIxqD78hw5CmIOoa1pnh+42+akCA4dNzNFnHSaPouQAAF/fkpsBwJLrmgDEvu10s/PJ78voiSfjQgE4se87tmO4fqi7YQD87l8ogHd41YTHkTkPfft/Y3frueHIhgKwt6ELE1ktJK85rClOd2t2oTjgOXhTEP414BN15E5NHmLCh5oW6Kqj0NXdwH9yloskApjGwLVHfqsV6oY3Rw59nZSr5Xh/jS5w4Z85MA1viwQAi9aNu97cCAGqLIE5tq0ICgCdM4EZgtH43Yu6lkkeAu97hwIIbR/Y5nj83vr0jX6ZrQ48Z+olAlBBOA1sN56Crp40jlY3iI0YNhFXRSJwLMNFAoANxI8cIzZRWRojH2zjCAlgCs+1gBmAyJvbYwMJwIUP8qeBsYUC8O0QmLFvuKUSwHhuzVuJAKyx3w3j7uhd3Y7+wPe24RXD3FqhHUABzGMXRMFojnSA4QZbdeu4elKZ/3hgG/lQAC46B1t4OPprRIHvJREF79Z8PA1Hf8Dc+tPuWtux6/zRn53pIufyUFX8Lz3Vyl9OzqvnhCBfjq3C71aapHDQwv/UkilBBoPBYDAYDAaDwWAwGAwGg8FgMBgMBoPBYDAYjJLyf+AuCGnnRzR1AAAAAElFTkSuQmCC").into(image);
        if(obj==null){
            obj=new Colorear();
            obj.execute(1);
            task.setText("Detener hilo");
        }else if(obj instanceof Colorear){
            obj.cancel(true);
            task.setText("Iniciar hilo");
        }
    }
    public void iniciarServicio(View d){
        Intent service = new Intent(this, MyService.class);
        startService(service);
    }
    public class Colorear extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected Void doInBackground(Integer... voids) {
            for(int i=0;i<=10;i++){
                if(obj.isCancelled()){
                    break;
                }else {
                    try {
                        publishProgress(voids[0],i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            colorearCampo.setBackgroundColor(Color.rgb(GenerarAleatorio2(),GenerarAleatorio2(),GenerarAleatorio2()));
            colorearCampo.setText("Param:"+values[0]+" iterador:"+values[1]);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            obj=null;
        }

        public int GenerarAleatorio2(){
            return  (int) (Math.random()*255);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    public int GenerarAleatorio(){
        return  (int) (Math.random()*255);
    }

    public void IrPedidos(View g){
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_game:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case R.id.help:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
