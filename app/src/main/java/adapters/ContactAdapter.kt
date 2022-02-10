package adapters

import MySharedPreferences.MySharedPreference
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.*
import android.view.WindowManager.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.*
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.modul_5_lesson_8_4_sms.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_view.view.*
import kotlinx.android.synthetic.main.item_sms.view.*
import models.Contact


class ContactAdapter(var context: Context, var contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        @RequiresApi(Build.VERSION_CODES.O)
        fun onBind(contact: Contact) {
            itemView.title.text = contact.name
            itemView.text.text = contact.number

            MySharedPreference.init(context)

            if (MySharedPreference.user == "home") {

                itemView.likeDialog.isVisible = true


            }





            itemView.cardItemSms.setOnClickListener {

                val alerdDialog = BottomSheetDialog(context, R.style.CustomBottomSheetDialogTheme)


                val viewDialog =
                    LayoutInflater.from(context).inflate(R.layout.dialog_view, null, false)


                viewDialog.txt_dialog_name.text = contact.name
                viewDialog.txt_dialog_text.text = contact.number




                if (viewDialog.txt_dialog_name.text == "Bugun tug'ilgan kunim") {
                    viewDialog.ll.layoutParams =
                        ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 880)
                }

                viewDialog.card_sms_dialog.setOnClickListener {
                    Toast.makeText(context, "Message", Toast.LENGTH_SHORT).show()
                    val smsBody =
                        "${viewDialog.txt_dialog_name.text} \n\n  ${viewDialog.txt_dialog_text.text}"
                    val sendIntent = Intent(Intent.ACTION_VIEW)
                    sendIntent.putExtra("sms_body", smsBody)
                    sendIntent.type = "vnd.android-dir/mms-sms"
                    startActivity(context, sendIntent, null)
                }

                viewDialog.card_share_dialog.setOnClickListener {
                    Toast.makeText(context, "Shared", Toast.LENGTH_SHORT).show()
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    val shareBody = "${viewDialog.txt_dialog_name.text} \n" +
                            "\n" +
                            "  ${viewDialog.txt_dialog_text.text}"
                    val shareSub = "Your subject here"
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub)
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                    val createChooser = Intent.createChooser(sharingIntent, "Share using")
                    startActivity(context, createChooser, null)
                }

                viewDialog.card_copy_dialog.setOnClickListener {
                    Toast.makeText(context, "copied", Toast.LENGTH_SHORT).show()

                    val clipboard = getSystemService(context, ClipboardManager::class.java)
                    clipboard?.setPrimaryClip(
                        ClipData.newPlainText(
                            "",
                            "${viewDialog.txt_dialog_name.text}\n${viewDialog.txt_dialog_text.text}"
                        )
                    )
                }


                viewDialog.card_saqlangan_dialog.setOnClickListener {

                    if (!itemView.likeDialog.isVisible) {
                        Toast.makeText(context, "Liked", Toast.LENGTH_SHORT).show()
                        viewDialog.heart.setImageResource(R.drawable.ic_like)
                        itemView.likeDialog.isVisible = true
                    } else {
                        Toast.makeText(context, "Disliked", Toast.LENGTH_SHORT).show()
                        viewDialog.heart.setImageResource(R.drawable.ic_like_empty)
                        itemView.likeDialog.isVisible = false
                    }

                    alerdDialog.dismiss()

                }


                alerdDialog.setContentView(viewDialog)

                alerdDialog.setCancelable(false)
                alerdDialog.setCanceledOnTouchOutside(true)


                alerdDialog.show()


            }

        }

    }


/*    fun dialogShow(contact: Contact){



    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sms, parent, false)

        var myViewHolder = MyViewHolder(itemView)


        return myViewHolder

    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val contact = contactList[position]
        holder.onBind(contact)


    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}