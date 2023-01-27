package fr.isen.mignottetheo.androidcontactds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.example.Results
import com.squareup.picasso.Picasso
import fr.isen.mignottetheo.androidcontactds.databinding.ActivityDetailBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Suppress("DEPRECATION")

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperer le profil choisi
        val contact = intent.getSerializableExtra("contactSelected") as Results

        //Modifier le titre en fct du contact selectionne
        binding.detailName.text = contact.name?.first + " " + contact.name?.last

        //Afficher image du contact
        val mealSelectedPic = contact.picture?.medium.toString()
        if (mealSelectedPic.isNotEmpty()) {
            Picasso.get().load(mealSelectedPic).into(binding.detailImage)
        }

        //Modifier adresse
        binding.detailAddress.text = contact.location?.street?.number.toString() + " " + contact.location?.street?.name
        binding.detailAddressOpt.text = contact.location?.city


        //Modifier mail
        binding.detailMail.text = contact?.email

        //Modifier num tel
        binding.detailPhone.text = contact?.phone

        //Modifier birthday
        val pattern = "dd-MM-yyyy"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val dateApi = contact?.dob?.date
        val date: Date = simpleDateFormat.parse(dateApi)

        val birthday = simpleDateFormat.format(date) + " (" + contact?.dob?.age + "yo)"

        binding.detailBirthday.text = birthday




    }
}