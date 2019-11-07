package com.ivstech.impostoimportacao

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ivstech.impostoimportacao.APIController.Regiao
import com.ivstech.impostoimportacao.APIController.RetrofitConfig
import com.tiper.MaterialSpinner
import retrofit2.Response

class FormularioCalculoImportacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_calculo_importacao)

        val call = RetrofitConfig().regiaoService().list()
        call.enqueue(object : retrofit2.Callback<List<Regiao>?>{
            override fun onResponse(call: retrofit2.Call<List<Regiao>?>?,
                                    response: Response<List<Regiao>?>?){
                response?.body()?.let {
                    val regioes: List<Regiao> = it
                    configureSpinner(regioes);
                    //Log.e("CEPService   ", "dados " + regioes[0].nome)
                }
            }
            override fun onFailure(call: retrofit2.Call<List<Regiao>?>?,
                                   t: Throwable?) {
            }
        })
    }

    private fun configureSpinner(regioes: List<Regiao>) {
        val spinner : MaterialSpinner = this.findViewById(R.id.spinner_uf_estado)
        var nomes: ArrayList<String> = ArrayList()
        for (i in regioes){
            nomes.add(i.nome)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nomes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
    }
}

/*val spinner : MaterialSpinner = this.findViewById(R.id.spinner_tipo_envio)

ArrayAdapter.createFromResource(
this,
R.array.tipos_envios,
android.R.layout.simple_spinner_item
).also { adapter ->
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter
}*/