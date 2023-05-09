package com.example.projetba2informatique

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button
import androidx.core.view.accessibility.AccessibilityViewCommand.SetTextArguments
import androidx.core.view.isVisible
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var Scan:Button
    lateinit var Rent:Button
    lateinit var Next:Button
    lateinit var Stop:Button
    lateinit var descriptif:TextView
    lateinit var solde:TextView

    private val ecurie = Ecurie()
    //public interface ecurie : Observable

    private val nombre_trotinette = 10
    private val nombre_voiture = 1
    private val MoneyAccount = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Next = findViewById(R.id.Next)
        Scan = findViewById(R.id.Scan) // Mes bouttons
        Rent = findViewById(R.id.Rent)
        Stop = findViewById(R.id.stp)

        Next.visibility = View.INVISIBLE // Rend certains Bouttons invisibles
        Stop.visibility = View.INVISIBLE
        Rent.visibility = View.INVISIBLE

        descriptif = findViewById(R.id.type) // Mes texts
        solde = findViewById(R.id.solde)

        solde.text = MoneyAccount.toString()
        val Account = Account.getInstance(MoneyAccount) // instancie l'account

        var liste_vehicules = arrayListOf<Vehicule>()
        var QRcode = 0
        var length = 0


        for(i in 1.rangeTo(nombre_trotinette)){ // Initialise les trotinettes
            ecurie.add(Trotinette(i))
        }
        for(i in 1.rangeTo(nombre_voiture)){ //Initialise les voitures
            ecurie.add(Voiture(i))
        }


        // Boutton : SCAN //

        Scan.setOnClickListener{

            liste_vehicules = ecurie.hasUpdated() // return: Liste contenant les vehicules utilisables à moins de 200m
            //QRcode=1 à tester
            length = liste_vehicules.size // Enregistre le nombre de vehicules utilisables
            if (length==0){
                descriptif.text = "il n'y a pas de vehicules disponibles à moins de 200m"
                Next.visibility = View.INVISIBLE
                Rent.visibility = View.INVISIBLE
            }
            else{
                descriptif.text = liste_vehicules[QRcode].describe() // Liste contenant toutes les infos à montrer su l'interface graphique
                // Reste plus qu'a changer l'interface graphique pour ce boutton !


                Next.visibility = View.VISIBLE
                Rent.visibility = View.VISIBLE
            }
        }




        // Boutton : RENT //

        Rent.setOnClickListener{

            if(Account.RemainingSolde()<50){
                descriptif.text = "Vous n'avez plus assez d'argent"
            }
            else if(liste_vehicules[QRcode].getUsability()==false){
                descriptif.text = "veuilliez appuyer sur le boutton \"NEXT\""
            }
            else{
                if(liste_vehicules[QRcode] is Voiture){
                    val voiture = liste_vehicules[QRcode] as Voiture
                    voiture.OpenDoor(false)
                }
                else if (liste_vehicules[QRcode] is Trotinette){
                    val trotinette = liste_vehicules[QRcode] as Trotinette
                    trotinette.Active(false)
                }
                else{ liste_vehicules[QRcode].Usable(false) }

                Rent.visibility = View.INVISIBLE
                Scan.visibility = View.INVISIBLE
                Next.visibility = View.INVISIBLE
                Stop.visibility = View.VISIBLE
            }
        }

        // Boutton : NEXT //

        Next.setOnClickListener{
            // Permet de passer d'un vehicule à un autre, et donc de revenir sur le vehicule initiale
            // s'arrete si: - Appuie sur le bouton "cancel"
            //              - Appuie sur le bouton "Rent"

            if (liste_vehicules[QRcode].getUsability()==false){
                ecurie.remove_vehicule(liste_vehicules[QRcode])
                length = liste_vehicules.size
                if (length==0){
                    descriptif.text = "il n'y a plus de vehicules disponibles à moins de 200m"
                    Next.visibility = View.INVISIBLE
                    Rent.visibility = View.INVISIBLE
                }
                else{
                    if(QRcode>=length){QRcode=0}
                    //QRcode -=1
                    descriptif.text = liste_vehicules[QRcode].describe()
                }
            }
            else{
                QRcode += 1
                if(QRcode>=length){QRcode=0}
                descriptif.text = liste_vehicules[QRcode].describe()
            }
        }

        // Boutton : STOP //

        Stop.setOnClickListener{
            val CarburantRestant = liste_vehicules[QRcode].moteur.getCarburantRestant()
            val CarburantConsome = liste_vehicules[QRcode].moteur.consomer()
            solde.text = Account.debit(CarburantRestant,CarburantConsome).toString()



            if(liste_vehicules[QRcode] is Voiture){
                val voiture = liste_vehicules[QRcode] as Voiture
                voiture.OpenDoor(true)
            }
            else if (liste_vehicules[QRcode] is Trotinette){
                val trotinette = liste_vehicules[QRcode] as Trotinette
                trotinette.Active(true)
            }
            else{ liste_vehicules[QRcode].Usable(false) } // !!!!!!!!!!!!!!!!!!!!!!


            val text = liste_vehicules[QRcode].describe() // NE PAS CHANGER CETTE LIGNE DE CODE
            descriptif.text = text // NE PAS CHANGER CETTE LIGNE DE CODE


            Next.visibility = View.VISIBLE
            Stop.visibility = View.INVISIBLE
            Scan.visibility = View.VISIBLE
            Rent.visibility = View.VISIBLE

        }
    }
}