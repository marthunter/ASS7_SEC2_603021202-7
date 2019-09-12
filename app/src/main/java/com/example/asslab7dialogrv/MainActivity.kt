package com.example.asslab7dialogrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val employeeList :ArrayList<Employee> = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        testEmp()
        recycler_view.adapter =EmployeeAdapter(this.employeeList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()

    }

    fun AddEmployeex(v: View){




        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout,null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener() {

                var radioGroup: RadioGroup = mDialogView.radiogroup
                var selectedId:Int = radioGroup.checkedRadioButtonId
                var radioButton: RadioButton = mDialogView.findViewById(selectedId)

                employeeList.add(Employee(mDialogView.edt_name.text.toString(), radioButton.text.toString()
                        , mDialogView.edt_mail.text.toString(), mDialogView.edt_sal.text.toString().toInt()
                    )
                )
                recycler_view.adapter?.notifyDataSetChanged()
                Toast.makeText(applicationContext, "Employess's Information is added", Toast.LENGTH_SHORT).show()
                mAlertDialog.dismiss()


        }

        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }


    }


    fun testEmp(){
        employeeList.add(Employee("Danny","Male","Danny@kku.ac.th",30000))
        employeeList.add(Employee("Sara","Female","Sara@kku.ac.th",34000))
    }


}
