package fr.isen.mignottetheo.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example.DataResult
import com.example.example.Results
import com.google.gson.Gson
import fr.isen.mignottetheo.androidcontactds.databinding.ActivityHomeBinding
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.homeTitle.text = "Mes contacts"

    }

    private fun loadContactsFromAPI() {
        val url = "https://randomuser.me/api/?results=10&nat=fr"

        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null, {
            Log.w("HomeActivity", "response : $it")
            handleAPIData(it.toString())
        }, {
            Log.w("HomeActivity", "error : $it")
        })

        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String) {
        val contactsResult = Gson().fromJson(data, DataResult::class.java)
        val contacts = contactsResult.results as ArrayList<Results>
        val adapter = binding.categoryList.adapter as ContactAdapter
    }
}