package com.zksolution.physicalfitnesstest.presentation.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.fragment_person_list.*

class PersonListFragment : BaseViewModelFragment<PersonViewModel>() {

    override fun getViewModelClass() = PersonViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_person_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personAdapter = PersonAdapter { person ->
            navigateToPersonEditor(person)
        }
        with(person_list_rv) {
            adapter = personAdapter
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL))
        }
//        disposable.add(viewModel.allPersons()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                personAdapter.setPersons(it)
//            })
        person_list_fab.setOnClickListener {
            //navigateToPersonEditor()
        }
    }

    private fun navigateToPersonEditor(person: Person = Person()) {
        //viewModel.selectedPerson = person
       // findNavController().navigate(
            //PersonListFragmentDirections.showPersonEditor()
       // )
    }
}