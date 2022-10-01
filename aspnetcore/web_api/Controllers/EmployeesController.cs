using System;
using System.Collections;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using web_api.Models;
using web_api.Services;

namespace web_api.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class EmployeesController : ControllerBase
    {
        public JsonEmployeeService EmployeeService { get; private set; }

        public EmployeesController(JsonEmployeeService employeeService)
        {
            EmployeeService = employeeService;
        }

        [HttpGet]
        public IEnumerable<Employee> Get()
        {
            return this.EmployeeService.GetEmployees();
        }
    }
}
