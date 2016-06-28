VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
	config.vm.box = "ubuntu-puppetlabs"
	config.vm.box_url = "http://puppet-vagrant-boxes.puppetlabs.com/ubuntu-server-12042-x64-vbox4210.box"

	config.vm.network :private_network, ip: "192.168.33.10"
	config.vm.network :public_network, bridge: "en0: Wi-Fi (AirPort)"

	config.vm.provision "shell" do |shell|
		shell.inline = "mkdir -p /etc/puppet/modules;
				(puppet module list | grep puppetlabs-java) || puppet module install puppetlabs-java"
	end

	config.vm.provision "puppet" do |puppet|
		puppet.manifests_path = "puppet/manifests"
		puppet.manifest_file = "default.pp"
	end
end
