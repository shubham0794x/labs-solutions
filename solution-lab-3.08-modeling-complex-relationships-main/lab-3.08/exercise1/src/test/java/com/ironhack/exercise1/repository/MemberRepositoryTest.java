package com.ironhack.exercise1.repository;

import com.ironhack.exercise1.enums.*;
import com.ironhack.exercise1.model.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.sql.Date;
import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private AssociationRepository associationRepository;

    private Integer memberId;
    private Integer chapterId;
    private Integer associationId;

    @BeforeEach
    void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 12, 01);
        Date date = new Date(calendar.getTimeInMillis());
        Association association = associationRepository.save(
                new Association(2, "Association 1"));
        Chapter chapter = chapterRepository.save(
                new Chapter(null, "Chapter 1", "Saladillo", association));
        Member member = memberRepository.save(
                new Member(chapter, "Jaume", Status.ACTIVE, date)
        );

        chapterId = chapter.getId();
        associationId = association.getId();
        memberId = member.getId();

    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
        chapterRepository.deleteAll();
        associationRepository.deleteAll();
    }

    @Test
    void chapterById_assertChapterExists_chapter() {

        Optional<Chapter> chapter = chapterRepository.findById(chapterId);

        assertTrue(chapter.isPresent());
        assertEquals("Chapter 1", chapter.get().getName());
    }

    @Test
    void memberById_assertMemberExists_member() {

        Optional<Member> member = memberRepository.findById(memberId);
        assertTrue(member.isPresent());
        assertEquals("Jaume", member.get().getName());
    }

    @Test
    void associationById_assertAssociationExists_association() {

        Optional<Association> association = associationRepository.findById(associationId);

        assertTrue(association.isPresent());
        assertEquals("Association 1", association.get().getName());
    }


}