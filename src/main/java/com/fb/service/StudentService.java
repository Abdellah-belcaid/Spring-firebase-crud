package com.fb.service;

import com.fb.model.Student;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class StudentService {

    public static final String COL_NAME = "students";

    public List<Student> getAllStudents() throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFirestore.collection(COL_NAME);
        ApiFuture<QuerySnapshot> future = collectionReference.get();

        List<Student> studentList = new ArrayList<>();

        // Iterate through the documents and add them to the list
        for (QueryDocumentSnapshot document : future.get().getDocuments()) {
            Student student = document.toObject(Student.class);
            studentList.add(student);
        }
        return studentList;
    }

    public String saveStudentDetails(Student student) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(student.getName()).set(student);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Student getStudentDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Student Student = null;

        if (document.exists()) {
            Student = document.toObject(Student.class);
            return Student;
        } else {
            return null;
        }
    }

    public String updateStudentDetails(Student person) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(person.getName()).set(person);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteStudent(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with Student ID " + name + " has been deleted";
    }
}
