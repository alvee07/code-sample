using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Logging;
using web_api.Models;
using web_api.Services;

namespace web_api.Pages
{
    public class IndexModel : PageModel
    {
        private readonly ILogger<IndexModel> _logger;
        private readonly JsonEmployeeService EmployeeService;
        public IEnumerable<Employee> Employees { get; private set; }


        public IndexModel(ILogger<IndexModel> logger, JsonEmployeeService employeeService)
        {
            _logger = logger;
            EmployeeService = employeeService;
        }

        public void OnGet()
        {
            Employees = EmployeeService.GetEmployees();
        }
    }
}
