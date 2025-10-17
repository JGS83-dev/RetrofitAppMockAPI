package com.dsm.retrofitappmockapi.ui.dashboard

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dsm.retrofitappmockapi.clases.Recursos
import com.dsm.retrofitappmockapi.databinding.FragmentDashboardBinding
import com.squareup.picasso.Picasso
import java.io.Serializable

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var recurso: Recursos = Recursos()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)



        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = requireArguments()
        if (bundle != null){
            recurso.id = bundle.getString("id")!!
            recurso.titulo = bundle.getString("titulo")!!
            recurso.tipo = bundle.getString("tipo")!!
            recurso.descripcion = bundle.getString("descripcion")!!
            recurso.enlace = bundle.getString("enlace")!!
            recurso.imagen = bundle.getString("imagen")!!

            Picasso.get().load(recurso.imagen).into(binding.imagenReferencia);
            binding.txtID.text = recurso.id
            binding.txtTipo.text = recurso.tipo
            binding.txtDescripcion.text = recurso.descripcion
            binding.txtEnlace.text = recurso.enlace
            binding.txtNombre.text = recurso.titulo
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}