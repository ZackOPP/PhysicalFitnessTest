package com.zksolution.physicalfitnesstest.presentation.person

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentPersonEditorBinding
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment

class PersonEditorFragment : BaseViewModelFragment<PersonViewModel>() {

    private lateinit var binding: FragmentPersonEditorBinding

    override fun getViewModelClass() = PersonViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_editor, container, false)
        return inflater.inflate(R.layout.fragment_person_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.person = viewModel.selectedPerson
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) = inflater.inflate(R.menu.editor_menu, menu)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.editor_menu_save) {
            //trySavePerson()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}