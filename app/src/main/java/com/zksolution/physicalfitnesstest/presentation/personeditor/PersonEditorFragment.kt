package com.zksolution.physicalfitnesstest.presentation.personeditor

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentPersonEditorBinding
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment

class PersonEditorFragment : BaseViewModelFragment<PersonEditorViewModel>() {

    private lateinit var binding: FragmentPersonEditorBinding

    override fun getViewModelClass() = PersonEditorViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_editor, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs = PersonEditorFragmentArgs.fromBundle(arguments!!)
        viewModel.person = safeArgs.person
        binding.person = viewModel.person
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