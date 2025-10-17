package com.dsm.retrofitappmockapi.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsm.retrofitappmockapi.R
import com.dsm.retrofitappmockapi.clases.Recursos
import com.dsm.retrofitappmockapi.clases.adapters.RecursosAdapter
import com.dsm.retrofitappmockapi.clases.body.RecursosResponse
import com.dsm.retrofitappmockapi.clases.service.RecursosApiService
import com.dsm.retrofitappmockapi.databinding.FragmentHomeBinding
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val BASE_URL = "https://68f240b6b36f9750deebfc08.mockapi.io/api/v1/"
    private var listaRecursos = ArrayList<Recursos>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitAPI: RecursosApiService = retrofit.create(RecursosApiService::class.java)

        retrofitAPI.callResources().enqueue(object : Callback<List<RecursosResponse>> {
            override fun onResponse(p0: Call<List<RecursosResponse>>, response: Response<List<RecursosResponse>>) {
                response.body()!!.forEach{
                    var recurso = Recursos(it.titulo,it.descripcion,it.tipo,it.enlace,it.imagen,it.id)
                    listaRecursos.add(recurso)
                }

                val recyclerViewItems: RecyclerView = binding.recyclerItems

                recyclerViewItems.layoutManager = LinearLayoutManager(context)

                val recursosAdapter = RecursosAdapter(requireContext(),listaRecursos,object : RecursosAdapter.RecursosListener {
                    override fun onItemClick(recursos: Recursos) {
                        navegarADetalles(recursos)
                    }
                })

                recyclerViewItems.adapter = recursosAdapter
            }

            override fun onFailure(p0: Call<List<RecursosResponse>>, p1: Throwable) {
                Log.i("callResources","Error al obtener recursos en linea de API Service: ${p1.message}")
            }
        })

        return root
    }

    private fun navegarADetalles(recursos: Recursos) {
        val bundle = Bundle()
        bundle.putString("id",recursos.id)
        bundle.putString("titulo",recursos.titulo)
        bundle.putString("tipo",recursos.tipo)
        bundle.putString("descripcion",recursos.descripcion)
        bundle.putString("enlace",recursos.enlace)
        bundle.putString("imagen",recursos.imagen)
        findNavController().navigate(R.id.navigation_dashboard,bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}