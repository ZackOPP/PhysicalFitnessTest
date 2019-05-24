package com.zksolution.physicalfitnesstest.presentation.personeditor

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.*
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentPersonEditorBinding
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import com.zksolution.physicalfitnesstest.presentation.common.DateHelper
import java.text.ParseException
import java.util.*

class PersonEditorFragment : BaseViewModelFragment<PersonEditorViewModel>() {

    private lateinit var binding: FragmentPersonEditorBinding

    private val calendar = Calendar.getInstance()

    private val dateListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        binding.personEditorBirthdayValue.text = DateHelper.getStringFromDate(calendar.time)
    }

    private val showDatePickerClickListener = View.OnClickListener {
        try {
            calendar.time = DateHelper.getDateFromString(binding.personEditorBirthdayValue.text.toString())
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        context?.let {
            DatePickerDialog(it,
                dateListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show()
        }
    }

    override fun getViewModelClass() = PersonEditorViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_editor, container, false)
        binding.personEditorCalendarIv.setOnClickListener(showDatePickerClickListener)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs = PersonEditorFragmentArgs.fromBundle(arguments!!)
        viewModel.person = safeArgs.person.copy()
        binding.viewModel = viewModel
        viewModel.successfullySaved.observe(viewLifecycleOwner, Observer {
            if (it) findNavController().navigateUp()
        })
        viewModel.savedMessage.observe(viewLifecycleOwner, Observer {
            showToast(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            showAlertDialog(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) = inflater.inflate(R.menu.editor_menu, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.editor_menu_save) {
            viewModel.trySavePerson()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showToast(messageId: Int) = Toast.makeText(context, messageId, Toast.LENGTH_LONG).show()

    private fun showAlertDialog(messageId: Int) =
        AlertDialog.Builder(context)
            .setTitle(getString(R.string.error))
            .setMessage(messageId)
            .setPositiveButton(getString(R.string.ok), null)
            .show()
}