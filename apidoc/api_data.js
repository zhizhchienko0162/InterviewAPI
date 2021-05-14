define({ "api": [
  {
    "type": "get",
    "url": "/interview/all",
    "title": "",
    "name": "GetInterviews",
    "group": "Interview",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "List(Interview)",
            "optional": false,
            "field": "interviews",
            "description": "<p>all interviews</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "put",
    "url": "/interview/add_question",
    "title": "",
    "name": "addQuestion",
    "group": "Interview",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Interview)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and interview with new questions</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Interview",
            "optional": false,
            "field": "interview",
            "description": "<p>updated interview</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "post",
    "url": "/interview/create",
    "title": "",
    "name": "createInterview",
    "group": "Interview",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Interview)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and new interview</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Interview",
            "optional": false,
            "field": "interview",
            "description": "<p>new interview</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "delete",
    "url": "/interview/del_question",
    "title": "",
    "name": "delQuestion",
    "group": "Interview",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Interview)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and interview with deleted questions</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Interview",
            "optional": false,
            "field": "interview",
            "description": "<p>updated interview</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "delete",
    "url": "/interview/delete",
    "title": "",
    "name": "deleteInterview",
    "group": "Interview",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Interview)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and interview</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "put",
    "url": "/interview/update",
    "title": "",
    "name": "updateInterview",
    "group": "Interview",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Interview)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and updated stopTimestamp and description for interview</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Interview",
            "optional": false,
            "field": "interview",
            "description": "<p>updated interview</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/InterviewController.java",
    "groupTitle": "Interview"
  },
  {
    "type": "post",
    "url": "/question/add",
    "title": "",
    "name": "addQuestions",
    "group": "Question",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Set(Questions))",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and set of questions</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Set(Questions)",
            "optional": false,
            "field": "questions",
            "description": "<p>set of questions</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "delete",
    "url": "/question/delete",
    "title": "",
    "name": "deleteQuestions",
    "group": "Question",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Set(Questions))",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and set of questions to delete</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "get",
    "url": "/question/all",
    "title": "",
    "name": "getQuestions",
    "group": "Question",
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "List(Questions)",
            "optional": false,
            "field": "questions",
            "description": "<p>all questions</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "put",
    "url": "/question/update",
    "title": "",
    "name": "updateQuestions",
    "group": "Question",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Set(Questions))",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user and set of updated questions</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Set(Questions)",
            "optional": false,
            "field": "questions",
            "description": "<p>set of questions</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/QuestionController.java",
    "groupTitle": "Question"
  },
  {
    "type": "post",
    "url": "/result/add",
    "title": "",
    "name": "addResult",
    "group": "Result",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Wrapper(User_Result)",
            "optional": false,
            "field": "wrapper",
            "description": "<p>login user(or user with empty token) and new result</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "Result",
            "optional": false,
            "field": "result",
            "description": "<p>new result</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/ResultController.java",
    "groupTitle": "Result"
  },
  {
    "type": "get",
    "url": "/result/all",
    "title": "",
    "name": "getResults",
    "group": "Result",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>login user</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "List(Result)",
            "optional": false,
            "field": "resutls",
            "description": "<p>all results</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/ResultController.java",
    "groupTitle": "Result"
  },
  {
    "type": "post",
    "url": "/user/login",
    "title": "",
    "name": "LoginUser",
    "group": "User",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>id and password</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>login User</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/UserController.java",
    "groupTitle": "User"
  },
  {
    "type": "post",
    "url": "/user/logout",
    "title": "",
    "name": "LogoutUser",
    "group": "User",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>login User</p>"
          }
        ]
      }
    },
    "version": "0.0.0",
    "filename": "src/main/java/com/gleb/interview/controller/UserController.java",
    "groupTitle": "User"
  }
] });
