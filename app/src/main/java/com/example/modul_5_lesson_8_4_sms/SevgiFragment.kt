package com.example.modul_5_lesson_8_4_sms

import adapters.ContactAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_saqlanganlar.view.*
import kotlinx.android.synthetic.main.fragment_sevgi.view.*
import models.Contact

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SevgiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SevgiFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var contactList: ArrayList<Contact>
    lateinit var contactAdapter: ContactAdapter

    lateinit var root:View

    var N = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root =  inflater.inflate(R.layout.fragment_sevgi, container, false)

        loadDate()
        contactAdapter = ContactAdapter(requireContext(),contactList)
        root.sevgiRV.adapter = contactAdapter

        root.sevgiTXT.text = "SEVGI SHE'RLAR"


        root.sevgiButton.setOnClickListener {
            findNavController().popBackStack()
        }


        return root
    }


    private fun loadDate() {

        contactList = ArrayList()


        contactList.add(
            Contact(1, "Quvonaman juda", "Quvonaman juda judayam,\n" +
                    "Quvonchizdan quvonar olam.\n" +
                    "Garchi gullar tutolmasam ham,\n" +
                    "Deyman Tug'ilgan kuningiz bilan!")
        )
        contactList.add(
            Contact(2, "Sizga tilaklar hali ko'p", "Sizga tilaklari hali ko'p bisyor,\n" +
                    "Baxtingiz gullasin go'yoki bahor.\n" +
                    "Ko'nglizda qolmasin zarracha g'ubor,\n" +
                    "Deyman Tug'ilgan kuningiz bilan!")
        )
        contactList.add(
            Contact(3, "Bu balki siz uchun katta", "Bu balki siz uchun katta sovg'amas, \n" +
                    "Balki bu umuman sovg'a ham emas. \n" +
                    "Bilaman baribir bundan quvonas, \n" +
                    "Deyman Tug'ilgan kuningiz bilan!")
        )
        contactList.add(
            Contact(4, "Bugun tug'ilgan kunim", "Bugun tug'ilgan kunim \n" +
                    "bordur ko'p orzularim \n" +
                    "shu orzularimda yashar \n" +
                    "mani aziz otajonim \n" +
                    "\n" +
                    "Men qancha ulg'aysam xam \n" +
                    "xatto yuzga to'lsam xam \n" +
                    "bir kun kelib o'lsam xam \n" +
                    "otajonim sog' bo'lsin \n" +
                    "volidam rozi bo'lsin \n" +
                    "\n" +
                    "Bugun tug'ilgan kunim \n" +
                    "bordur ko'p orzularim \n" +
                    "shu orzularimda yashar \n" +
                    "mani aziz onajonim \n" +
                    "\n" +
                    "Men azobda qolsam xam \n" +
                    "goh dardlardan tolsam xam \n" +
                    "bir kun kelib sevsam xam \n" +
                    "onamni duosi bo'lsin \n" +
                    "kelin onamga qiz bo'lsin \n" +
                    "\n" +
                    "Bugun tug'ilgan kunim \n" +
                    "bordur ko'p orzularim \n" +
                    "shu orzularimda yashar \n" +
                    "mani yolg'iz sevganim \n" +
                    "\n" +
                    "Tanho uni sevsam xam \n" +
                    "bahtli bo'lsa bahtliman \n" +
                    "sevgim o'zgaga bo'lsa xam \n" +
                    "men uni sevay xar dam \n" +
                    "\n" +
                    "Bugun tug'ilgan kunim \n" +
                    "bordur ko'p orzularim \n" +
                    "shu orzularimda yashar \n" +
                    "saytdagi muxlislarim \n" +
                    "\n" +
                    "Men sizlarni sevarman \n" +
                    "sherlarimda yozarman \n" +
                    "xar biringiz birdek menga \n" +
                    "jonim fidodur sizlarga"
            )
        )
        contactList.add(
            Contact(5, "Ushbu kunda tilaklar ummon bir olam", "Ushbu kunda tilaklarimummon bir olam,\n" +
                    "Unda yo'q aslo g'am tashvishualam.\n" +
                    "Dunyodagi tilaklar bo'lgandaxam jam,\n" +
                    "Siz uchun baribir u tilaklar kam.\n" +
                    "Nasib etsin jannatlar. \n" +
                    "Yiroq ketsinkulfatlar. \n" +
                    "Sizga bir shirin tilak.\n" +
                    "Tug'ilgan kun muborak.")
        )
        contactList.add(
            Contact(6, "Tug'ilgan kuninggiz muborak bo'lsin", "Do'stim baxt iqbol doim yor bo'lsin \n" +
                    "Yurgan yo'llariz gullarga to'lsin \n" +
                    "Omadingiz ko'rib ko'zlar quvonsin \n" +
                    "Tug'ulgan kuningiz muborak bo'lsin! \n" +
                    "Soginchlardan yasay sizga guldasta \n" +
                    "Guldasta qilib qalbim payvasta \n" +
                    "Olislardan turib deyman men asta \n" +
                    "Tug'ilgan kuningiz muborak bo'lsin!")
        )
        contactList.add(
            Contact(7, "Doim kulib yuring tabassum bilan", "Doim kulib yuring tabassum bilan.\n" +
                    "Yashang doim baxtga oshyona.\n" +
                    "Mexrdan poyizga to'shayman gilam.\n" +
                    "Tug'ulgan kuningiz bilan ona.")
        )


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SevgiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SevgiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}